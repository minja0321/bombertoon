package Common;

import server.Color;

public class Setting {
	public static final int P = 4;
	public static int[] STAGE4ONE = FieldData.fieldDate1;
	public static int[] STAGE4TWO = FieldData.fieldDate1;
	public static Color ColorTeam1 = Color.Blue;
	public static Color ColorTeam2 = Color.Blue;

	public static void setTeamColor(Color[] cl) {
		ColorTeam1 = cl[0];
		ColorTeam2 = cl[1];
	}
}