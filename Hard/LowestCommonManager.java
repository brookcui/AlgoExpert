import java.util.*;

class Program {
	private static OrgChart lowestCommonManager = null;
	
	// O(n) time | O(d) space
  public static OrgChart getLowestCommonManager(
      OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
    // Write your code here.
    dfs(topManager, reportOne, reportTwo);
		return lowestCommonManager;
  }
	
	private static int dfs(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
		if (manager == null) {
			return 0;
		}
		int numOfImportantReports = 0;
		for (OrgChart directReport : manager.directReports) {
			int reports = dfs(directReport, reportOne, reportTwo);
			numOfImportantReports += reports;
		}
		if (manager == reportOne || manager == reportTwo) {
			numOfImportantReports++;
		}
		if (numOfImportantReports >= 2) {
			lowestCommonManager = manager;
		}
		return (numOfImportantReports > 0) ? 1 : 0;
	}

  static class OrgChart {
    public char name;
    public List<OrgChart> directReports;

    OrgChart(char name) {
      this.name = name;
      this.directReports = new ArrayList<OrgChart>();
    }

    // This method is for testing only.
    public void addDirectReports(OrgChart[] directReports) {
      for (OrgChart directReport : directReports) {
        this.directReports.add(directReport);
      }
    }
  }
}
