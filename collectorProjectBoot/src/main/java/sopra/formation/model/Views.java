package sopra.formation.model;

import sopra.formation.model.Views.ViewCommon;

public class Views {
	public static class ViewCommon {}
	
	public static class ViewCompte extends ViewCommon {}
	
	public static class ViewAdmin extends ViewCompte {}

	public static class ViewUtilisateur extends ViewCompte {}
	
	public static class ViewAdresse extends ViewCommon {}


	public static class ViewPublication extends ViewCommon {}
	public static class ViewParticipationEnchere extends ViewCommon {}
	public static class ViewCategorie extends ViewCommon {}
}