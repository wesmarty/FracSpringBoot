
$(document).ready(function() {
	
      	$("#run1").click(function(event){
      		event.preventDefault();
      		var id = $("#proId").val();
      		url = "/simulate";
      		$.ajax({
      			url:url,
      			data:{pId:id},
      			success:function(){
      				$("#myBar").show();
      				move();
      				$("#compSimulation").show(3000);
      			}
      		});
      	});      	
      	
          $("#rl").click(function(){
          	url = "/reservoirLithology/showLithology";
          	var id = $("#proId").val();
          	$.ajax({
          		url: url,
          		data:{pid:id},
          		success: function(data){
          			$("#loadtable").html(data);
                  	jQuery("#exampleModal").modal('show');
          		}
          	});
            
          });
         
          $('#ip').click(function(){
          	var pid=$("#proId").val();
      		url="/injectionPlan/showinjection";
      		$.ajax({
      			url:url,
      			data:{pid:pid},
      			success:function(data){
      				$("#loadtable").html(data);
                  	jQuery("#exampleModal").modal('show');
      			}
      		});
      	});
          
          $('#wd').click(function(){
          	url="/wellData";
          	var id = $("#proId").val();
          	$.ajax({
          		url:url,
          		data:{pro_Id:id},
          		success:function(data){
          			$("#loadtable").html(data);
                  	jQuery("#exampleModal").modal('show');
          		}
          	});
          });
          
          $('#pe').click(function(){
          	url="/pumping/showpump";
          	var id = $("#proId").val();
          	$.ajax({
          		url:url,
          		data:{pid:id},
          		success:function(data){
          			$("#loadtable").html(data);
                  	jQuery("#exampleModal").modal('show');
          		}
          	});
          });
          
          $('#fl').click(function(){
          	var x=$("#proId").val();                                       		
          	
          	url="/showFLFirstController";                   	
          	$.ajax({
          		url:url,
          		data:{pid:x},
          		success:function(data){
          			$("#loadtable").html(data);
                  	jQuery("#exampleModal").modal('show');
          		}
          	});
          });
          
          $("#pp").click(function(){
        	  url="/proppant/showproppant";
        	  var id = $("#proId").val();
        	  $.ajax({
        		  url:url,
        		  data:{pid:id}, 
        		  success:function(data){
            			$("#loadtable").html(data);
                    	jQuery("#exampleModal").modal('show');
        		  }
        	  });
        	  
          });
          $("#wf").click(function(){
        	  url="/wellforcast/showforcast";
        	  var id = $("#proId").val();
        	  $.ajax({
            		url:url,
            		data:{pid:id},
            		success:function(data){
            			$("#loadtable").html(data);
                    	jQuery("#exampleModal").modal('show');
            		}
            	});
          });
          
          $("#rfp").click(function(){
          	url="/reservoirFluid1/showreservoir1";
          	var id = $("#proId").val();
          	$.ajax({
          		url:url,
          		data:{pid:id},
          		success:function(data){
          			$("#loadtable").html(data);
                  	jQuery("#exampleModal").modal('show');
          		}
          	});
          });
          
          $("#sa").click(function(){
        	  url="/stressanalysis/showstress";
            	var id = $("#proId").val();
            	$.ajax({
            		url:url,
            		data:{pid:id},
            		success:function(data){
            			$("#loadtable").html(data);
                    	jQuery("#exampleModal").modal('show');
            		}
            	});
          });
          
          $("#rp").click(function(){
          	url="/rockProperties/showrock";
          	var id = $("#proId").val();
          	$.ajax({
          		url:url,
          		data:{pid:id},
          		success:function(data){
          			$("#loadtable").html(data);
                  	jQuery("#exampleModal").modal('show');
          		}
          	});
          });
          
          $("#if").click(function(){
          	url="/injectedfluid1/showfluid1";
          	var x=$("#proId").val();
          	$.ajax({
          		url:url,
          		data:{pro_Id:x},
          		success:function(data){
          			$("#loadtable").html(data);
                  	jQuery("#exampleModal").modal('show');
          		}
          	});
          });
          
          $("#mf").click(function(){
          	var x=$("#proId").val();
          	url="/miniFrac";
          	$.ajax({
          		url:url,
          		data:{pro_Id:x},
          		success:function(data){
          			$("#loadtable").html(data);
                  	jQuery("#exampleModal").modal('show');
          		}
          	});
          });
          
});

	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Document.ready() ENDS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
function move() {
	  var elem = document.getElementById("myBar");   
	  var width = 10;
	  var id = setInterval(frame, 10);
	  function frame() {
	    if (width >= 100) {
	      clearInterval(id);
	    } else {
	      width++; 
	      elem.style.width = width + '%'; 
	      elem.innerHTML = width * 1  + '%';
	    }
	  }
	}