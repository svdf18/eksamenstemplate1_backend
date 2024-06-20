package kea3.eksamenstemplate1_backend.agegroup;

public enum AgeGroupEnum {
    CHILDREN(6, 9),
    YOUTH(10, 13),
    JUNIOR(14, 22),
    ADULT(23, 40),
    SENIOR(41, Integer.MAX_VALUE);

    private final int minAge;
    private final int maxAge;

    AgeGroupEnum(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public static AgeGroupEnum getAgeGroupByAge(int age) {
        for (AgeGroupEnum ageGroup : values()) {
            if (age >= ageGroup.minAge && age <= ageGroup.maxAge) {
                return ageGroup;
            }
        }
        throw new IllegalArgumentException("No age group found for age: " + age);
    }
}