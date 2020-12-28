import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MatrixAndWordTest {
    private static MatrixAndWord matrix;

    @BeforeAll
    public static void beforeAll() {
        matrix = new MatrixAndWord();
    }

    @Test
    public void testForInputNullAndEmpty() {
        String expected = "";
        String actual = matrix.getSequence(null, "KING");
        String secondActual = matrix.getSequence("QWERTSFFT", null);
        String thirdActual = matrix.getSequence("", "");
        assertEquals(expected, actual,
                String.format("You should return empty String, but you returned %s", actual));
        assertEquals(expected, secondActual,
                String.format("You should return empty String, but you returned %s", secondActual));
        assertEquals(expected, thirdActual,
                String.format("You should return empty String, but you returned %s", thirdActual));
        String fourthActual = matrix.getSequence("KLKLK", "");
        assertEquals(expected, fourthActual,
                String.format("You should return empty String, but you returned %s", fourthActual));
    }

    @Test
    public void testForOneLetterInInputWord() {
        String firstExpected = "[0,0]";
        String firstActual = matrix.getSequence("K", "K");
        assertEquals(firstExpected, firstActual,
                String.format("You should return %s, but you returned %s",
                        firstExpected, firstActual));
    }

    @Test
    public void incorrectLengthOfWords() {
        assertThrows(RuntimeException.class, () -> matrix.getSequence("KAASASASAS", "LA"));
        assertThrows(RuntimeException.class, () -> matrix.getSequence("K", "LAAAAAAAAA"));
        assertThrows(RuntimeException.class, () -> matrix.getSequence("", "LA"));
    }

    @Test
    void correctValues_OK() {
        String firstExpected = "[1,2]->[1,3]->[0,3]->[0,2]";
        String secondExpected = "[3,2]->[3,3]->[2,3]->[1,3]->[1,4]->[1,5]->[2,5]->[2,4]";
        String thirdExpected = "[7,5]->[6,5]->[5,5]->[5,6]->[6,6]->[7,6]->[8,6]->[9,6]->[10,6]"
                + "->[11,6]->[11,7]->[11,8]" + "->[11,9]->[11,10]->[11,11]";
        String firstActual = matrix.getSequence("QLGNAEKIRLRNGEAE", "KING");
        String secondActual = matrix.getSequence("ADGGHEETUPUTCDNMREMOCODHPRAAGNCDCCCN",
                "COMPUTER");
        String thirdActual = matrix.getSequence("EQWEAfSDFFXZGFQWQoLCKAZXCCASWe)Vf@COFNVDDu(4N#YGD"
                        + "BCERg17gSAVPDSWTAG%YLPQaqVAAEUGxTKFdwXSMLEXM[JWneVASeOBNGJDerXZXaFCDFH"
                        + "XgtXZNgLMD]GAelfoeueGends",
                "LEAGUEOFLEGENDS");
        assertEquals(firstExpected, firstActual,
                String.format("You should return %s, but you returned %s",
                        firstExpected, firstActual));
        assertEquals(secondExpected, secondActual,
                String.format("You should return %s, but you returned %s",
                        secondExpected, secondActual));
        assertEquals(thirdExpected, thirdActual, String.format("You should return %s, "
                        + "but you returned %s",
                thirdExpected, thirdActual));
        String fourthExpected = "No matches founded!";
        String fourthActual = matrix.getSequence("EQWEAfSDFFXZGFQWQoLCKAZXCCASWe)Vf@COFNVDDu(4N#"
                + "YGDBCERg17gSAVPDSWTAG%YLPQaqVAAEUGxTKFdwXSMLEXM[JWneVASeOBNGJDerXZXa"
                + "FCDFHXgtXZNgLMD]GAelfoeueGeER)", "PHENOMENA");
        assertEquals(fourthExpected, fourthActual, String.format("You should return %s, "
                        + "but you returned %s",
                fourthExpected, fourthActual));
        String fifthExpected = "[12,11]->[12,12]->[12,13]->[11,13]->[10,13]->[9,13]->[9,14]"
                + "->[9,15]->[9,16]->[10,16]->[11,16]->[12,16]->[13,16]->[14,16]->[15,16]->"
                + "[16,16]->[17,16]->[18,16]->[19,16]->[19,15]->[19,14]->[19,13]->[19,12]->"
                + "[19,11]->[19,10]->[19,9]->[19,8]";
        String fifthActual = matrix.getSequence("QWERTYUIOPASDFGHJKLZZXCVBinidutilGHDCVERFDSSZBDQ"
                + "ERTYiNJYXVWSXGDSAQQQWADAbNHSZYLLVBXZXDAAAXSZaBSASKKZYWQAFSFDZVCXcVCVFGCXEdutil"
                + "ibacificabilitRASUYIZVBNZiUASLOLFuAFDTSIXCBNXrTETIRWUdSQERFEWASVCoMificDNiSAZZ"
                + "ZDFJKMMnTRDDaESnSSXCVBGHBNBoRoYFbROiibacifironoHonSFiIFtlYYZYAASFFFFnQMHlTUaiY"
                + "ZYSAQHDFDSoHGGiINtyZZXXSWFYFQQrWGHtLNTuZFDFSRGSRTFYRYYuLYEdYYFGFTZADFFQRZXdINS"
                + "iZZXAbcsDAAEARBNiHMTnitatiuasubitatinCLW", "HONORIFICABILITUDINITATIBUS");
        assertEquals(fifthExpected, fifthActual, String.format("You should return %s, "
                        + "but you returned %s",
                fourthExpected, fourthActual));
    }
}
