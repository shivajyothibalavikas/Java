var studentTable;

jQuery(document).ready(function() {

	studentTable = jQuery('#bookListTable').dataTable({
		
		"sPaginationType" : "full_numbers",
		"iDisplayLength": 10,
		"bProcessing" : true,
		"bServerSide" : true,
		"sAjaxSource" : "/Login/jsp/display.do",
			
		"aoColumns" : 
		   [ {"bSearchable" : false,	"bVisible" : false,	"asSorting" : [ "asc" ]	},
    	   {"sWidth" : "20%","bSortable" : true },
     	   {"sWidth" : "20%","bSortable" : true },
     	   {"sWidth" : "20%","bSortable" : true }
	    ]
	});
	jQuery(".ui-corner-br").addClass('ui-widget-header_custom');

});