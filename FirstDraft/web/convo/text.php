<?php
	
	$groups = array(
		array(
			"name" => "math", 
			"creator" => "name",
			"members" => "Bob",
			"tags" => "group, hi"
		),
		array(
			"name" => "trade", 
			"creator" => "lols",
			"members" => "Bob",
			"tags" => "group, hi"
		),
		array(
			"name" => "store", 
			"creator" => "name",
			"members" => "Bob",
			"tags" => "group, hi"
		),
		array(
			"name" => "mcdonalds", 
			"creator" => "lols",
			"members" => "Bob",
			"tags" => "group, hi"
		),
		array(
			"name" => "police", 
			"creator" => "name",
			"members" => "Bob",
			"tags" => "group, hi"
		),
		array(
			"name" => "watch", 
			"creator" => "lols",
			"members" => "Bob",
			"tags" => "group, hi"
		)
	);

	echo json_encode($groups);

?>