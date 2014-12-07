<?php

if ($_GET['type'] == "convos") {
	$groups = array(
		array(
			"name" => "lolsci", 
			"creator" => "name",
			"type" => "convo",
			"members" => "Bob",
			"tags" => array("one", "two", "three")
		),
		array(
			"name" => "trade", 
			"creator" => "lols",
			"type" => "convo",
			"tags" => array("one", "two", "three")
		),
		array(
			"name" => "store", 
			"creator" => "name",
			"type" => "convo",
			"tags" => array("one", "two", "three")
		),
		array(
			"name" => "mcdonalds", 
			"creator" => "lols",
			"type" => "convo",
			"tags" => array("one", "two", "three")
		),
		array(
			"name" => "police-watch", 
			"creator" => "name",
			"type" => "convo",
			"tags" => array("one", "two", "three")
		),
		array(
			"name" => "government-news", 
			"creator" => "lols",
			"type" => "convo",
			"tags" => array("one", "two", "three")
		),
		array(
			"name" => "commuity", 
			"creator" => "lols",
			"type" => "convo",
			"tags" => array("one", "two", "three")
		)
	);
}

if ($_GET['type'] == "shops") {
	$groups = array(
		array(
			"name" => "SHOP1", 
			"creator" => "name",
			"type" => "shops",
			"tags" => array("one", "two", "atan")
		),
		array(
			"name" => "SHOP12", 
			"creator" => "lols",
			"type" => "shops",
			"tags" => array("one", "two", "rg")
		),
		array(
			"name" => "SHOP134", 
			"creator" => "name",
			"type" => "shops",
			"tags" => array("one", "two", "g")
		),
		array(
			"name" => "mcdonalds", 
			"creator" => "lols",
			"type" => "shops",
			"tags" => array("one", "two", "aaa")
		),
		array(
			"name" => "lolshops", 
			"creator" => "name",
			"type" => "shops",
			"tags" => array("one", "two", "thrrgaagee")
		)
	);	
}


	echo json_encode($groups);

?>