/**
 * Script pour cacher une partie du formulaire
 */


function hideTaux($){
	
	$(taux).display(true);
	$(decouvert).display(false);
	
};

function hideDecouvert($){
	
	$(taux).display(false);
	$(decouvert).display(true);
	
};

