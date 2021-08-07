package direction;

public enum DirectionImpl implements Direction {

    NORTH('N', new int[]{0, 1}){
        @Override
        public Direction left() {
            return WEST;
        }

        @Override
        public Direction right() {
            return EAST;
        }
    }, EAST('E', new int[]{1, 0}) {
        @Override
        public Direction left() {
            return NORTH;
        }

        @Override
        public Direction right() {
            return SOUTH;
        }

    }, SOUTH('S', new int[]{0, -1}) {
        @Override
        public Direction left() {
            return EAST;
        }

        @Override
        public Direction right() {
            return WEST;
        }
    }, WEST('W', new int[]{-1, 0}) {
        @Override
        public Direction left() {
            return SOUTH;
        }

        @Override
        public Direction right() {
            return NORTH;
        }
    };

    char letter;
    int[] forward;

    DirectionImpl(char letter, int[] forward) {
        this.letter = letter;
        this.forward = forward;
    }

    @Override
    public int[] forwards() {
        return this.forward;
    }

    @Override
    public char getLetter() {
        return letter;
    }

    public static Direction getDirection(char c) {
        return switch (c) {
            case 'E' -> EAST;
            case 'S' -> SOUTH;
            case 'W' -> WEST;
            default -> NORTH;
        };
    }


}
