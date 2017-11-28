package drumkit;

public class DrumKitTestDrive {
		public static void main (String []args) {
			DrumKit d = new DrumKit();
			for(int i = 1; i <= 5;i++) {
			d.playSnare();
			d.playTopHat();
			}
			d.snare = false;
			if(d.snare == true) {
				d.playSnare();
			}
		}
}
