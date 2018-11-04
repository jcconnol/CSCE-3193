<html>
<?php
if($_REQUEST == null){
	echo "<title>Assignment 9: no query string</title>";
	echo "Hello World!<br>";
	echo "John Connolly's assignment 9<br>";
	echo "The query string is null";
}

else{
	echo "<title>Assignment 9: with a query string</title>";
	echo "Hello World!<br>";
	echo "John Connolly's assignment 9<br>";
	echo "The query string is ", var_dump($_REQUEST);
}

phpinfo();

?>
</html>
