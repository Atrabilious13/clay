package atra.clay.constants;

import org.powerbot.game.api.wrappers.Tile;



public class Constants {

		// ids
		public final static int clay = 434;
		public final static int softClay = 1761;
		public final static int pump = 3460;
		public static int[] rockIds = { 10577, 10578, 10579 };

		// tiles
		public final static Tile atRocks = new Tile(3141, 3317, 0);
		public final static Tile atPump = new Tile(3095, 3272, 0);
		public final static Tile atBank = new Tile(3092, 3243, 0);

		// tilepaths
		public static final Tile[] toRocks = {
				new Tile(3091, 3245, 0), new Tile(3092, 3250, 0),
				new Tile(3097, 3250, 0), new Tile(3102, 3251, 0),
				new Tile(3105, 3255, 0), new Tile(3105, 3260, 0),
				new Tile(3106, 3265, 0), new Tile(3105, 3270, 0),
				new Tile(3105, 3275, 0), new Tile(3105, 3280, 0),
				new Tile(3107, 3285, 0), new Tile(3108, 3290, 0),
				new Tile(3111, 3295, 0), new Tile(3114, 3299, 0),
				new Tile(3118, 3303, 0), new Tile(3121, 3307, 0),
				new Tile(3125, 3310, 0), new Tile(3129, 3313, 0),
				new Tile(3134, 3315, 0), new Tile(3139, 3317, 0),
				new Tile(3141, 3317, 0)
		};
		
		public static final Tile[] toPump = {
				new Tile(3140, 3318, 0), new Tile(3135, 3316, 0),
				new Tile(3131, 3313, 0), new Tile(3128, 3309, 0),
				new Tile(3125, 3305, 0), new Tile(3121, 3302, 0),
				new Tile(3116, 3300, 0), new Tile(3113, 3296, 0),
				new Tile(3111, 3291, 0), new Tile(3110, 3286, 0),
				new Tile(3108, 3281, 0), new Tile(3107, 3276, 0),
				new Tile(3102, 3274, 0), new Tile(3098, 3271, 0),
				new Tile(3095, 3272, 0)
		};
		
		public static final Tile[] toBank = {
				new Tile(3095, 3270, 0), new Tile(3095, 3267, 0),
				new Tile(3095, 3264, 0), new Tile(3095, 3260, 0),
				new Tile(3095, 3257, 0), new Tile(3095, 3253, 0),
				new Tile(3096, 3251, 0), new Tile(3095, 3249, 0),
				new Tile(3093, 3248, 0), new Tile(3092, 3244, 0)
		};
		
		 
		
		//for paint
		private static String status = "";
		private static long startTime;
		private static int profit = 0, clayMined = 0, claySoftened = 0, sapphires = 0, emeralds = 0, rubys = 0, diamonds = 0;
	
		public static void setStartTime(long time) {
			startTime = time;
		}
		
		public long getStartTime() {
			return startTime;
		}
		
		public static void setStatus(String s) {
			status = s;
		}
		
		public String getStatus() {
			return status;
		}

		public static int getProfit() {
			return profit;
		}

		public static void addProfit(int gain) {
			profit += gain;
		}

		public static int getClayMined() {
			return clayMined;
		}

		public static void addClayMined() {
			clayMined++; 
		}

		public static int getClaySoftened() {
			return claySoftened;
		}

		public static void addClaySoftened() {
			claySoftened++;
		}

		public static int getSapphires() {
			return sapphires;
		}

		public static void addSapphires() {
			sapphires++;
		}

		public static int getEmeralds() {
			return emeralds;
		}

		public static void addEmeralds() {
			emeralds++;
		}

		public static int getRubys() {
			return rubys;
		}

		public static void addRubys() {
			rubys++;
		}

		public static int getDiamonds() {
			return diamonds;
		}

		public static void addDiamonds() {
			diamonds++;
		}
		
		
}
