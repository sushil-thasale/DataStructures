/*tower of hanoi*/
import java.io.*;

class TowerOpeartions {
	public void moveTower(int height, String fromPeg, String toPeg,
			String usingPeg) {
		if (height <= 0) {
			// do nothing
		} else {
			moveTower(height - 1, fromPeg, usingPeg, toPeg);
			moveDisc(height, fromPeg, toPeg);
			moveTower(height - 1, usingPeg, toPeg, fromPeg);
		}
	}

	public void moveDisc(int discNo, String fromPeg, String toPeg) {
		System.out.println("Move disc " + discNo + " from " + fromPeg + " to "
				+ toPeg);
	}
}

class TowerOFHanoi {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int towerHeight = 0;
		try {
			towerHeight = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		TowerOpeartions op = new TowerOpeartions();
		op.moveTower(towerHeight, "A", "B", "C");
	}
}
