<!DOCTYPE html>
<html>
<body>

<?php
if($_SERVER["REQUEST_METHOD"] == "POST"){
	if($_POST["number_guess"] == $_POST["right_ans"]){
		echo "That is the correct answer. I hope this was fun";
	} else {
		?>
		<form name="guessform" method="post" action="assignment10.php">
				<table>
				<tr>
				<td align="right">That is the incorrect answer, guess again:</td>
				<td align="left"><input type="number" name="number_guess" value="<?php echo $_POST["number_guess"]; ?>" required></td>
				</tr>
				<tr>
				<td align="left"><input type="hidden" name="right_ans" value="<?php echo $_POST["right_ans"]; ?>" ></td>
				</tr>
				</table>
			<input type="submit" method="post" action="assignment10.php">
		</form>
		<?php
	}	
}

elseif(!empty($_GET)){
	echo "Hello ".htmlspecialchars($_GET["firstname"])." ".htmlspecialchars($_GET["lastname"]);
	echo "<br><br>";
	echo "Let's play a little game...";
	echo "<br>";
	
	?>
		<form name="guessform" method="post" action="assignment10.php">
				<table>
				<tr>
				<td align="right">Guess a number between 1 and 5:</td>
				<td align="left"><input type="number" name="number_guess" value="0" required></td>
				</tr>
				<tr>
				<td align="left"><input type="hidden" name="right_ans" value="<?php echo rand(1,5); ?>" ></td>
				</tr>
				</table>
			<input type="submit" method="post" action="assignment10.php">
		</form>
	<?php
}

else{
	?>
		<script>
		function validation(){
			if(!document.forms["nameform"]["emailadd"].value.includes("@")){
				alert("no \"@\" character in email adress");
				return false; 
			} else if(!document.forms["nameform"]["emailadd"].value.includes(".")) { 
				alert("no \".\" character in email adress");
				return false; 
			} else { return true; }
		};
		</script>
		<form name="nameform" method="get" action="assignment10.php" onsubmit="return validation()">
			<table>
				<tr>
				<td align="right">First name:</td>
				<td align="left"><input type="text" name="firstname" value="John" required></td>
				</tr>
				<tr>
				<td align="right">Last name:</td>
				<td align="left"><input type="text" name="lastname" value="Connolly" required></td>
				</tr>
				<tr>
				<td align="right">Email Address:</td>
				<td align="left"><input type="email" name="emailadd" value="jcconnol@uark.edu" required></td>
				</tr>
			</table>
			<input type="submit" onsubmit="return validation()" method="get" action="assignment10.php">
		</form>
	<?php
}
?>

</body>
</html>
