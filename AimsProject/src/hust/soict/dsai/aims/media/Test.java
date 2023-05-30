package hust.soict.dsai.aims.media;

public class Test {

	public static void main(String[] args) {
		Track track1 = new Track(10);
		Track track2 = new Track(20);
		Track track3 = new Track(30);
		Track track4 = new Track(40);
		
		CompactDisc tst = new CompactDisc();
		tst.addTrack(track1);
		tst.addTrack(track2);
		tst.addTrack(track3);
		System.out.println(tst.getLength());
		tst.addTrack(track4);
		System.out.println(tst.getLength());
		tst.removeTrack(track3);
		System.out.println(tst.getLength());
	}
}
