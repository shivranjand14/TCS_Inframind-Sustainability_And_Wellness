<?php
class FB{
 public $link='';
 function __construct(){
  $this->connect();
  $this->storeInDB();
 }
 
 function connect(){
  $this->link = mysqli_connect('182.50.133.77','prabudh','Prabudh@123') or die('Cannot connect to the DB');
  mysqli_select_db($this->link,'prabudhbharat') or die('Cannot select the DB');
 }
 
 function storeInDB(){
	  
  $query = "select count(id) from health_monitor_data where bodytemprature < 97 or bodytemprature > 99 or bloodpressure > 120 or respiratoryrate < 12 or respiratoryrate > 16 or glucose > 140 or heartrate < 60 or heartrate > 100 or oxygensaturation < 95 or oxygensaturation > 100 or electrocardiogram < 120 or electrocardiogram > 200 or bloodsugar > 140";
  $result = mysqli_query($this->link,$query) or die('Errant query:  '.$query);
echo ".$result.";
  }
 
}

 $FB=new FB();

?>
