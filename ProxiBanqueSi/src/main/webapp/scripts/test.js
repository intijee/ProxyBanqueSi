/**
 * Script pour cacher une partie du formulaire
 */


function hideTaux($){
	
	$(taux).disable(true);
	$(decouvert).disable(false);
	
};

function hideDecouver($){
	
	$(taux).disable(false);
	$(decouvert).disable(true);
	
};

