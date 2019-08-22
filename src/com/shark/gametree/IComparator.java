package com.shark.gametree;

import java.util.Comparator;

public interface IComparator extends Comparator<Integer> {

    int initialValue();

    IComparator opposite();

    public static final IComparator MAX = new IComparator() {
        public int compare(Integer sc1, Integer sc2) {
            // handle null cases.
            if (sc1 == null) {
                if (sc2 == null) {
                    return 0;
                } // why not
                return -1;
            }
            if (sc2 == null) {
                return +1;
            }

            if (sc1 > sc2) return +1;
            if (sc1 < sc2) return -1;
            return 0;
        }

        public String toString() {
            return "MAX";
        }

        public int initialValue() {
            return Integer.MIN_VALUE;
        }

        public IComparator opposite() {
            return MIN;
        }
    };

    public static final IComparator MIN = new IComparator() {
        public int compare(Integer sc1, Integer sc2) {
            if (sc1 == null) {
                if (sc2 == null) {
                    return 0;
                }
                return +1;
            }
            if (sc2 == null) {
                return -1;
            }
            if (sc1 < sc2) return +1;
            if (sc1 > sc2) return -1;
            return 0;
        }

        /** Useful for debugging. */
        public String toString() {
            return "MIN";
        }

        public int initialValue() {
            return Integer.MAX_VALUE;
        }

        public IComparator opposite() {
            return MAX;
        }
    };
}
