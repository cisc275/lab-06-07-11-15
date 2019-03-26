package Files;
public enum Direction {
	
	NORTH(0), 
	NORTHEAST(1), 
	EAST(2), 
	SOUTHEAST(3), 
	SOUTH(4), 
	SOUTHWEST(5), 
	WEST(6), 
	NORTHWEST(7), 
	FIRE_NORTH(8), 
	FIRE_SOUTH(9), 
	FIRE_EAST(10), 
	FIRE_WEST(11),
	FIRE_NORTHEAST(12),
	FIRE_NORTHWEST(13),
	FIRE_SOUTHEAST(14),
	FIRE_SOUTHWEST(15),
	JUMP_NORTH(16),
	JUMP_SOUTH(17),
	JUMP_EAST(18),
	JUMP_WEST(19),
	JUMP_NORTHEAST(20),
	JUMP_NORTHWEST(21),
	JUMP_SOUTHEAST(22),
	JUMP_SOUTHWEST(23);
	
	private Integer hierarchy;

    private Direction(final Integer hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Integer getHierarchy() {
        return hierarchy;
    }


}