package Files;
public enum Direction {
	NORTH(0), NORTHEAST(1), EAST(2), SOUTHEAST(3), SOUTH(4), SOUTHWEST(5), WEST(6), NORTHWEST(7);
	
	private Integer hierarchy;

    private Direction(final Integer hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Integer getHierarchy() {
        return hierarchy;
    }


}