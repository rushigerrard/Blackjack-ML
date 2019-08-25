package model;

public enum Decision {
	HIT("H"), STAND("S"), DOUBLEDOWN("D"), SPLIT("SP"), OTHER;

    String key;

    Decision(String key) { this.key = key; }

    //default constructor, used only for the OTHER case, 
    //because OTHER doesn't need a key to be associated with. 
    Decision() { }

    Decision getValue(String x) {
		if ("H".equals(x)) {
			return HIT;
		} else if ("S".equals(x)) {
			return STAND;
		} else if ("D".equals(x)) {
			return DOUBLEDOWN;
		} else if ("SP".equals(x)) {
			return SPLIT;
		}
        else if (x == null) { return OTHER; }
        else throw new IllegalArgumentException();
    }
}
