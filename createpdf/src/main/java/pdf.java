import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class pdf extends PdfPageEventHelper {
    ArrayList<Data> data;
    String[] smallTable = {"Account Number", "Invoice", "Date", "Invoice Amount"};
    String[] CentreTable = {"S.NO","Item", "Description", "Unit Cost", "Discount", "Quantity", "Price Excl. VAT"};

    pdf() {
        data = new ArrayList<Data>();
    }

    public static void main(String[] args) {

        pdf pdf = new pdf();
        Document document = new Document();


        try {
            File f = new File("/home/akhil/repo_bill.pdf");

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
            f.createNewFile();

            MyFooter event = new MyFooter();
            writer.setPageEvent(event);
            document.open();
            document.newPage();
            event.onEndPage(writer, document);

            //fonts
            Font font = FontFactory.getFont(FontFactory.COURIER_BOLD, 10, BaseColor.BLACK);
            Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15, BaseColor.WHITE);

            PdfPTable table = new PdfPTable(1);
            table.setWidthPercentage(100);
            Paragraph paragraph = new Paragraph("TAX INVOICE", font1);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            PdfPCell pdfPCell = new PdfPCell();
            pdfPCell.setBackgroundColor(BaseColor.BLACK);
            pdfPCell.addElement(paragraph);
            table.addCell(pdfPCell);
            document.add(table);

            Image image = Image.getInstance("/home/akhil/Desktop/tangerine.jpg");
            image.scaleAbsolute(120, 120);
            image.setAlignment(Element.ALIGN_RIGHT);


            paragraph = new Paragraph("Tangerine Ltd\n " +
                    "Plot No 26\n" +
                    "Kanjokya Street, Kamowkya\n " +
                    "PO Box 37136\n" +
                    "Kampala, Uganda " +
                    "\nPhone: +256 414 235 536/537 ", font);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            paragraph.add(new Chunk(image, 225, 10));
            paragraph.add(new Chunk(new Chunk(new VerticalPositionMark())));
            paragraph.add(new Phrase("                 "));
            paragraph.add(new Phrase("New Tin No: 1000114927", font));
            paragraph.add(new Chunk(new Chunk(new VerticalPositionMark())));
            paragraph.add(new Phrase("\nEmail: accounts@tangerine.co.ug", font));
            paragraph.add(new Chunk(new Chunk(new VerticalPositionMark())));
            paragraph.add(new Phrase("VAT No: 48799-W", font));
            document.add(paragraph);

            paragraph = new Paragraph("\nbhargav\n" +
                    "Tin No. N/A\n" +
                    "Mobile No. - 9482022227\n" +
                    "Consequat Voluptate\n" +
                    "572 Rocky Hague Drive\n" +
                    "Belfast\n" +
                    "Velit asperiores min\n" +
                    "Uganda", font);
            paragraph.setAlignment(Element.ALIGN_LEFT);

            table = new PdfPTable(2);
            table.setWidthPercentage(50);
            table.setSpacingAfter(10f);
            table.setSpacingBefore(10f);

            for (String title : pdf.smallTable) {
                pdfPCell = new PdfPCell(new Phrase(title, font));
                pdfPCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(pdfPCell);
                table.addCell(new PdfPCell(new Phrase("")));
            }
            table.setHorizontalAlignment(Element.ALIGN_RIGHT);
            document.add(paragraph);
            paragraph.add(new Chunk(new VerticalPositionMark()));
            document.add(table);

            table = new PdfPTable(7);
            table.setWidthPercentage(100);
            for (String center : pdf.CentreTable) {
                pdfPCell = new PdfPCell(new Phrase(center, font));
                pdfPCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(pdfPCell);
            }
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            document.add(table);

            table = new PdfPTable(7);
            table.setWidthPercentage(100);

            for (int i = 1; i <= table.getNumberOfColumns(); i++) {
                if (i == 1){
                    pdfPCell = new PdfPCell(new Phrase(" "+i));
                    pdfPCell.setFixedHeight(300);
                    table.addCell(pdfPCell);

                }
                pdfPCell = new PdfPCell(new Phrase(" your text here"));
                pdfPCell.setFixedHeight(300);
                table.addCell(pdfPCell);
            }
            document.add(table);

            document.newPage();

            table = new PdfPTable(1);
            table.setWidthPercentage(100);
            paragraph = new Paragraph("TAX INVOICE", font1);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            pdfPCell = new PdfPCell();
            pdfPCell.setBackgroundColor(BaseColor.BLACK);
            pdfPCell.addElement(paragraph);
            table.addCell(pdfPCell);
            document.add(table);


            table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setKeepTogether(true);

            pdfPCell = new PdfPCell(new Phrase("\n"));
            font.setSize(8);
            pdfPCell.addElement(new Phrase("Authoriesed Siganture:", font));
            pdfPCell.setPaddingBottom(5);

            table.addCell(pdfPCell);
            Phrase p = new Phrase("Narration:\n", font);
            p.add("Being data internet charges for the period of May 2019");
            pdfPCell = new PdfPCell(p);
            table.addCell(pdfPCell);
            document.add(table);


            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



