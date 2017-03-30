/**
 * Script pour cacher une partie du formulaire
 */


function hideTaux(){

	document.getElementById("taux").disabled=true;
	document.getElementById("decouvert").disabled=false;
	
};

function hideDecouvert(){
	
	document.getElementById("taux").disabled=false;
	document.getElementById("decouvert").disabled=true;
	
};

