package org.example.resumeanalyzer;


public class Analyse {
    int matchPercentage;
    String[] toImprove;

    Analyse (String filePath, String job)  {
        String extractedText = FileExtractor.extractTextFromPDF(filePath);
        String[] skills = DBconnect.getJobRequirements(job);
        int matchPercentage = Analyzer.match(skills, extractedText);
        String[] unmatched = Analyzer.unmatchedSkills(skills, extractedText);

        this.matchPercentage = matchPercentage;
        this.toImprove = unmatched;
    }
}

//class Mainnn {
//    public static void main(String[] args) throws SQLException, IOException {
//        Analyse me = new Analyse("C:\\Users\\jerry\\Downloads\\checkNothing.pdf", "Software Engineer");
//        System.out.println(me.matchPercentage + " " + Arrays.toString(me.toImprove));
//    }
//}{

