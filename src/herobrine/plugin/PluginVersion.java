package herobrine.plugin;

public class PluginVersion implements Comparable<PluginVersion> {

	private int major, minor, build;

	public PluginVersion(int major, int minor, int build) {
		this.major = major;
		this.minor = minor;
		this.build = build;
	}

	@Override
	public int compareTo(PluginVersion other) {
		if(this.major > other.major) {
			return 1;
		} else if(this.major < other.major) {
			return -1;
		} else {
			if(this.minor > other.minor) {
				return 1;
			} else if(this.minor < other.minor) {
				return -1;
			} else {
				if(this.build > other.build) {
					return 1;
				} else if(this.build < other.build) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}

	@Override
	public String toString() {
		return major + "." + minor+ "." + build;
	}
	
	
	
}
