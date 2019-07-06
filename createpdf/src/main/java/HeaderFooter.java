import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

class MyFooter extends PdfPageEventHelper {

    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte cb = writer.getDirectContent();
        Font font = FontFactory.getFont(FontFactory.COURIER_BOLD, 8, BaseColor.BLACK);


        Phrase footer = new Phrase("We declare that this invoices shows the actual price of the goods described and that all particulars" , font);


        Phrase footer1 = new Phrase("________________________________________________________________________________________");
        Phrase footer2 = new Phrase("are True and correctIf you have any queries, please contact accounts department immediately.",font);

        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                footer1,
                (document.right() + 10 - document.left() - 10) / 2 + document.leftMargin(),
                document.bottom() + 41, 0);

        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                footer2,
                (document.right() + 10 - document.left() - 10) / 2 + document.leftMargin(),
                document.bottom() + 26, 0);


        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                footer,
                (document.right() + 10 - document.left() - 10) / 2 + document.leftMargin(),
                document.bottom() + 33, 0);
    }
}