<?php
session_start();
if(isset($_REQUEST['clear'])) {
	session_unset();
	session_destroy();
	session_start();
}

$empty_form1 = false;
$empty_form2 = false;
function add_user($add_user, $add_pass, $add_fname, $add_lname){
	if(strlen($add_user) == 0 || strlen($add_pass) == 0 || strlen($add_fname) == 0 || strlen($add_lname) == 0){
		global $empty_form2;
		$empty_form2 = true;
		return false;
	}
	
	$file = fopen("assignment11-account-info.txt", "r") or exit("unable to open file");
	while(!feof($file)){
		$line = fgets($file);
		if(strlen($line)>0){	
		 	$arr2 = explode(";",$line);
			if($add_user == $arr2[0] || $add_pass == $arr2[1]){
				echo "<script>alert(\"Password or Username taken.\")</script><br>";
				fclose($file);
				return false;
			}
		}
	}

	fclose($file);
	$filewrite = fopen("assignment11-account-info.txt", "a+") or die("unable to open file");
	$string_add = $add_user.";".$add_pass.";".$add_fname.";".$add_lname.";white;Welcome to John Connolly's Assignment 11 PHP Page!;https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Stick_Figure.svg/170px-Stick_Figure.svg.png\n";
	fwrite($filewrite, $string_add);
	fclose($filewrite);
	$_SESSION['username'] = $add_user;
	$_SESSION['password'] = $add_pass;
	$_SESSION['loggedin'] = true;
        return true;
}

function login($username, $password){
	if(strlen($username) == 0 || strlen($password) == 0){
		global $empty_form1;
		$empty_form1 = true;
		return false;
	}
	$file = fopen("assignment11-account-info.txt", "r") or exit("unable to open file");
	while(!feof($file)){
		$line = fgets($file);
		if(strlen($line)>0){	
		 	$arr = explode(";",$line);
			if($username == $arr[0] && $password == $arr[1]){
				fclose($file);
				$_SESSION['username'] = $username;
				$_SESSION['password'] = $password;
				$_SESSION['loggedin'] = true;
				return true;
			}
		}
	}
	fclose($file);
	echo "<script>alert(\"Password or Username does not exist.\")</script><br>";
	return false;
}

function information_edit($username, $password, $fname, $lname, $back_color, $title, $image){
	$file = fopen("assignment11-account-info.txt", "a+") or exit("unable to open file");
	while(!feof($file)){
		$line = fgets($file);
		if(strlen($line)>0){	
		 	$arr = explode(";",$line);
			if($username == $arr[0] && $password == $arr[1]){
				//put stuff for getting variables in here
				$name = explode(" ", $arr[2]);
				$fname = $name[0];
				$lname = $name[1];
			
				if(isset($arr[3]) || $arr[3] != " "){
					$back_color = $arr[3];
				}
				if(isset($arr[4]) || $arr[4] != " "){
					$title = $arr[4];
				}
				if(isset($arr[5]) || $arr[5] != " "){
					$image = $arr[5];
				}
			}
		}
	}
	fclose($file);
}

function change_aspects($username, $password, $firstname, $lastname, $bacolor, $top_title, $image_link){
        $file = fopen("assignment11-account-info.txt", "r") or exit("unable to open file");

	$changedFile = "";
	while(!feof($file)){
		$line = fgets($file);
		if(strlen($line)>0){	
		 	$arr = explode(";",$line);
			if($username == $arr[0] && $password == $arr[1]){
                                

				$string_add = $username.";".$password.";".$firstname.";".$lastname.";".$bacolor.";".$top_title.";".$image_link;
				$changedFile = $changedFile . $string_add;
			}
			else {
				$changedFile = $changedFile . $line;
			}
		}

	}
	fclose($file);

	$file = fopen("assignment11-account-info.txt", "w") or exit("unable to open file");
	fwrite($file, $changedFile);

}
$user;
$pass;
$firstname;
$lastname;
$back_color;
$title;
$image = "";

if((isset($_GET["username"]) && login($_GET["username"], $_GET["password"])) || 
	(isset($_GET["make_username"]) && add_user($_GET["make_username"], $_GET["make_password"], $_GET["first_name"],$_GET["last_name"])) ){

	//variables for person's page...
	
	$file = fopen("assignment11-account-info.txt", "r") or exit("unable to open file");
	while(!feof($file)){
		$line = fgets($file);
		if(strlen($line)>0){	
		 	$arr = explode(";",$line);
                        if($_SESSION["username"] == $arr[0] ){
			        //put stuff for getting variables in here
                                //global $user, $pass, $firstname, $lastname;
			        $user = $arr[0];
			        $pass = $arr[1];
			        $firstname = $arr[2];
			        $lastname = $arr[3];
			
			        if(isset($arr[4]) && $arr[4] != " "){
			//	        global $back_color;
				        $back_color = $arr[4];
			        }
			        if(isset($arr[5]) && $arr[5] != " "){
			//	        global $title;
				        $title = $arr[5];
			        }
			        if(isset($arr[6]) && $arr[6] != " "){
			//	        global $image;
				        $image = $arr[6];
			        }
                        }
		}
	}
	fclose($file);
}
else if ( isset($_GET['bacolor']) ) {
	change_aspects($_SESSION['username'], $_SESSION['password'], $_GET['fname'], $_GET['lname'], $_GET['bacolor'], $_GET['top_title'], $_GET['image_link']);
	$firstname = $_GET['fname'];
	$lastname = $_GET['lname'];
	$back_color = $_GET['bacolor'];
	$title = $_GET['top_title'];
	$image = $_GET['image_link'];
	
}

if ( isset($_SESSION['loggedin']) ) {
        
	?>
	<!DOCTYPE html><html>
	<style>body{ background-color: <?php echo $back_color; ?> }</style>
	<title><?php echo $title; ?></title>
	<h1 align="center"><?php echo $title; ?></h1>
	<p><?php echo "Welcome ".$firstname." ".$lastname."!"; ?></p>
	<form name="user_page" method="get">
		<img src="<?php echo $image; ?>" style="width:128px;height:128px;">
		<table>
		<tr>
		<td align="right">First name: </td>
		<td align="left"><input type="text" name="fname" value="<?php echo $firstname; ?>"></td>
		</tr>
		<tr>
		<td align="right">Last name: </td>
		<td aign="left"><input type="text" name="lname" value="<?php echo $lastname; ?>"></td>
		</tr>
		<tr>
		<td align="right">Background color: </td>
		<td aign="left"><input type="text" name="bacolor" value="<?php echo $back_color; ?>"></td>
		</tr>
		<tr>
		<td align="right">Title: </td>
		<td aign="left"><input type="text" name="top_title" value="<?php echo $title; ?>"></td>
		</tr>
		<tr>
		<td align="right">Image: </td>
		<td aign="left"><input type="text" name="image_link" value="<?php echo $image; ?>"></td>
		</tr>
		</table>
		<input value="Edit Account Information" type="submit" method="get" action="assignment11.php">
	</form>
	<br><button name="Logout"  onclick="window.location='assignment11.php?clear=true'">Logout</button>
<?php
}
else{
?>
<!DOCTYPE html>
<html>
<title>John Connolly's Assignment 11 PHP page!</title>
<h1 align="center">John Connolly's Assignment 11 PHP page!</h1>
	<form name="already_user" method="get" action="assignment11.php">
		<table>
		<tr>
		<td align="right">Username: </td>
		<td align="left"><input type="text" name="username"></td>
		</tr>
		<tr>
		<td align="right">Password: </td>
		<td aign="left"><input type="password" name="password"></td>
		</tr>
		</table>
		<input type="submit" method="get" action="assignment11.php">
	</form>
	<br>
	<?php if($empty_form1){ echo "A field was left empty<br>"; }?>
	<br>
	<form name="make_a_user" method="get" action="assignment11.php">
		<table>
		<tr>
		<td align="right">Username: </td>
		<td align="left"><input type="text" name="make_username"></td>
		</tr>
		<tr>
		<td align="right">Password: </td>
		<td aign="left"><input type="password" name="make_password"></td>
		</tr>
		<tr>
		<td align="right">First Name: </td>
		<td aign="left"><input type="text" name="first_name"></td>
		</tr>
		<tr>
		<td align="right">Last Name: </td>
		<td aign="left"><input type="text" name="last_name"></td>
		</tr>
		</table>
		<input type="submit" method="get" action="assignment11.php">
	</form>
	<?php if($empty_form2){ echo "<br>A field was left empty"; }?>
<?php
}
?>
</body>
</html>
