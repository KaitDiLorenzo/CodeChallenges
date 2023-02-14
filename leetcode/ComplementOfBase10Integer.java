class ComplementOfBase10Integer {
    public int bitwiseComplement(int n) {
        StringBuilder binary = new StringBuilder(Integer.toBinaryString(n));

        for(int i = 0; i < binary.length(); i++) {
            binary.replace(i, i + 1, binary.charAt(i) == '0' ? "1" : "0");
        }

        return Integer.parseInt(binary.toString(), 2);
    }
}