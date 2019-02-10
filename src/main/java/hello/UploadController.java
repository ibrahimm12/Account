package hello;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Receiver;
import com.vaadin.flow.router.Route;

import java.io.*;

@Route
public class UploadController extends VerticalLayout {

   // private LineBreakCounter counter = new LineBreakCounter();
   // private Deque<StreamVariable.StreamingStartEvent> lastStartedEvent = new ArrayDeque<>();
   // private Upload upload = null;

//    public UploadController(MainView mainView) {
//
//        this.editor = editor;
//        this.upload = new Upload(counter);
//        this.mainView = mainView;
//
//        upload.addSucceededListener(new ComponentEventListener<SucceededEvent>() {
//
//            @Override
//            public void onComponentEvent(SucceededEvent event) {
//                System.out.println(event.getFileName());
//                System.out.println(counter.getCSVString());
//                }
//        });
//
//    }


    public static class LineBreakCounter implements Receiver {

        private String fileName;
        private String mtype;
        private int counter;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        public OutputStream receiveUpload(String filename, String MIMEType) {


            counter = 0;
            fileName = filename;
            mtype = MIMEType;
            return baos;

        }


        public String getFileName() {
            return fileName;
        }

        public String getMimeType() {
            return mtype;
        }

        public int getLineBreakCount() {
            return counter;
        }



        public String getCSVString() {
            byte [] ba =  baos.toByteArray();
            try {
                return new String(ba,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}

