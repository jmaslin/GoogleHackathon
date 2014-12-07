<?php
	
	$groups = array(
		array(
			"name" => "group1", 
			"creator" => "name",
			"members" => "Bob",
			"tags" => "group, hi"
		),
		array(
			"name" => "group2", 
			"creator" => "lols",
			"members" => "Bob",
			"tags" => "group, hi"
		)
	);

	echo json_encode($groups);

?>