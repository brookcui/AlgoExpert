import java.util.*;

class Program {
	// O(h) time | O(1) space
	public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne,
			AncestralTree descendantTwo) {
		// Write your code here.
		int depthOne = getDescendantDepth(topAncestor, descendantOne);
		int depthTwo = getDescendantDepth(topAncestor, descendantTwo);
		if (depthOne > depthTwo) { // one lower than two
			AncestralTree ancestorOneAtDescendantTwoLevel = backtrackAncestralTree(descendantOne, depthOne - depthTwo);
			return getCommonAncestor(ancestorOneAtDescendantTwoLevel, descendantTwo);
		} else { // one higher than two or at the same depth
			AncestralTree ancestorTwoAtDescendantOneLevel = backtrackAncestralTree(descendantTwo, depthTwo - depthOne);
			return getCommonAncestor(descendantOne, ancestorTwoAtDescendantOneLevel);
		}
	}

	private static int getDescendantDepth(AncestralTree topAncestor, AncestralTree descendant) {
		int depth = 0;
		while (descendant != topAncestor) {
			++depth;
			descendant = descendant.ancestor;
		}
		return depth;
	}

	private static AncestralTree backtrackAncestralTree(AncestralTree tree, int steps) {
		while (steps > 0) {
			tree = tree.ancestor;
			--steps;
		}
		return tree;
	}

	private static AncestralTree getCommonAncestor(AncestralTree descendantOne, AncestralTree descendantTwo) {
		while (descendantOne != descendantTwo) {
			descendantOne = descendantOne.ancestor;
			descendantTwo = descendantTwo.ancestor;
		}
		return descendantOne;
	}

	static class AncestralTree {
		public char name;
		public AncestralTree ancestor;

		AncestralTree(char name) {
			this.name = name;
			this.ancestor = null;
		}

		// This method is for testing only.
		void addAsAncestor(AncestralTree[] descendants) {
			for (AncestralTree descendant : descendants) {
				descendant.ancestor = this;
			}
		}
	}
}
