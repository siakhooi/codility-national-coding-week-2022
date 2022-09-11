package nsh.codility;

import java.util.ArrayList;

public class NationalCodingWeek2022A implements NationalCodingWeek2022Interface {
	public void updateLevel(int from, int n, int level) {
		maxLevel = Math.max(level, maxLevel);
		for (int i = 0; i < Connected.get(n).size(); i++) {
			int c = Connected.get(n).get(i); // [n][i];
			if (c != from)
				updateLevel(n, c, level + 1);
			else
				Level[level]++;
		}
	}

	int[] Level;
	ArrayList<ArrayList<Integer>> Connected;
	int maxLevel = 0;

	public int solution(int[] A, int[] B) {
		int R = 0;
		int N = A.length + 1;
		Connected = new ArrayList<ArrayList<Integer>>(N);
		for (int i = 0; i < N; i++)
			Connected.add(new ArrayList<Integer>());

		for (int i = 0; i < A.length; i++) {
			int a = A[i], b = B[i];
			Connected.get(a).add(b);
			Connected.get(b).add(a);
		}
		Level = new int[N];
		Level[0]++;
		updateLevel(-1, 0, 0);

		for (int i = maxLevel; i > 0; i--)
			for (int j = i - 1; j >= 0; j -= 2)
				R += (Level[i] * Level[j]);

		return R;
	}

}
