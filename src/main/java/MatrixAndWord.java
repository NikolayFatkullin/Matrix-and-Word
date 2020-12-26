public class MatrixAndWord {
    private static final int VARIABLE_TO_CHECK_LENGTH = 1;
    private static final int[] ROWS_ARRAY_STEPS = new int[]{-1, 0, 1, 0};
    private static final int[] COLUMN_ARRAY_STEPS = new int[]{0, 1, 0, -1};
    private static final String STRING_FORMAT_FOR_RESULT = "[%d,%d]";

    public String getSequence(String firstWord, String secondWord) {
        if (firstWord == null || secondWord == null || secondWord.equals("")) {
            return "";
        }
        if (firstWord.length() <= 1 && firstWord.equals(secondWord)) {
            return "[0,0]";
        }
        if (Math.sqrt(firstWord.length()) % VARIABLE_TO_CHECK_LENGTH != 0) {
            throw new RuntimeException("Incorrect size of first word!");
        }
        if (secondWord.length() > firstWord.length()) {
            throw new RuntimeException("Incorrect size of second word!");
        }
        char[][] wordsMatrix = stringToMatrix(firstWord);
        String resultedSequence;
        for (int i = 0; i < wordsMatrix.length; i++) {
            for (int j = 0; j < wordsMatrix.length; j++) {
                resultedSequence = searchInMatrix(wordsMatrix, i, j, secondWord, 0);
                if (!resultedSequence.equals("Incorrect")) {
                    return resultedSequence;
                }
            }
        }
        return "No matches founded!";
    }

    private char[][] stringToMatrix(String word) {
        int matrixLength = (int) Math.sqrt(word.length());
        char[] temporaryArray = word.toUpperCase().toCharArray();
        char[][] matrix = new char[matrixLength][matrixLength];
        int indexForArray = 0;
        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixLength; j++) {
                matrix[i][j] = temporaryArray[indexForArray];
                indexForArray++;
            }
        }
        return matrix;
    }

    private String searchInMatrix(char[][] wordsMatrix, int rows, int columns,
                                  String word, int charIndex) {
        if (wordsMatrix[rows][columns] != word.charAt(charIndex)) {
            return "Incorrect";
        }
        StringBuilder result = new StringBuilder();
        result.append(String.format(STRING_FORMAT_FOR_RESULT, rows, columns));
        if (charIndex >= word.length() - 1) {
            return result.toString();
        }
        char tmp = wordsMatrix[rows][columns];
        wordsMatrix[rows][columns] = '#';

        for (int i = 0; i < 4; i++) {
            int checkedRow = rows + ROWS_ARRAY_STEPS[i];
            int checkedColumn = columns + COLUMN_ARRAY_STEPS[i];
            if (checkedRow >= 0 && checkedRow < wordsMatrix.length
                    && checkedColumn >= 0 && checkedColumn < wordsMatrix[0].length
                    && wordsMatrix[checkedRow][checkedColumn] == word.charAt(charIndex + 1)) {
                String temporaryResult = searchInMatrix(wordsMatrix, checkedRow, checkedColumn,
                        word, charIndex + 1);
                if (!temporaryResult.equals("Incorrect")) {
                    result.append("->").append(temporaryResult);
                    return result.toString();
                }
            }
        }
        wordsMatrix[rows][columns] = tmp;
        return "Incorrect";
    }
}
