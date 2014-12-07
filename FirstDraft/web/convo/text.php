<?php

if ($_GET['type'] == "convos") {
	$groups = array(
		array(
			"name" => "lolsci", 
			"architect" => "name",
			"type" => "convo",
			"members" => "Bob",
			"tags" => array("one", "two", "three")
		),
		array(
			"name" => "trade", 
			"architect" => "lols",
			"type" => "convo",
			"tags" => array("one", "two", "three")
		),
		array(
			"name" => "store", 
			"architect" => "name",
			"type" => "convo",
			"tags" => array("one", "two", "three")
		),
		array(
			"name" => "mcdonalds", 
			"architect" => "lols",
			"type" => "convo",
			"tags" => array("one", "two", "three")
		),
		array(
			"name" => "police watch group", 
			"architect" => "name",
			"type" => "convo",
			"tags" => array("one", "two", "three")
		),
		array(
			"name" => "government news", 
			"architect" => "lols",
			"type" => "convo",
			"tags" => array("one", "two", "three")
		),
		array(
			"name" => "commuity", 
			"architect" => "lols",
			"type" => "convo",
			"tags" => array("one", "two", "three")
		)
	);
}

if ($_GET['type'] == "shops") {
	$groups = array(
		array(
			"name" => "SHOP1", 
			"architect" => "name",
			"type" => "shops",
			"tags" => array("one", "two", "atan")
		),
		array(
			"name" => "SHOP12", 
			"architect" => "lols",
			"type" => "shops",
			"tags" => array("one", "two", "rg")
		),
		array(
			"name" => "SHOP134", 
			"architect" => "name",
			"type" => "shops",
			"tags" => array("one", "two", "g")
		),
		array(
			"name" => "mcdonalds", 
			"architect" => "lols",
			"type" => "shops",
			"tags" => array("one", "two", "aaa")
		),
		array(
			"name" => "lolshops", 
			"architect" => "name",
			"type" => "shops",
			"tags" => array("one", "two", "thrrgaagee")
		)
	);	
}


	echo json_encode($groups);

?>