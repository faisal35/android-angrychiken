<?php
	include 'koneksi.php';
	
	if(isset($_POST['function'])){
		$function = $_POST['function'];
		if($function=="login"){
			$username = $_POST['username'];
			$password = $_POST['password'];
			if(mysqli_num_rows(mysqli_query($con, "select * from user where username='$username' and password='$password'"))>=0){
				$response["success"] = 1;

				$result = array();
				$result["hasil"] = $response;
				print(json_encode($result));
			}else{
				$response["success"] = 0;

				$result = array();
				$result["hasil"] = $response;
				print(json_encode($result));
			}
		}
	}
?>