package hello;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.router.Route;
import com.vaadin.server.Page;
import com.vaadin.ui.Notification;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Route
public class MainView extends VerticalLayout {

    private final AccountRepository repository;
    private final UploadController uploadController;



    //private final AccountEditor editor;

    final Grid<Account> grid;

   private UploadController.LineBreakCounter counter = new UploadController.LineBreakCounter();


    private Upload upload = null;



    public MainView( AccountRepository repository,UploadController uploadController    ) {
            this.repository = repository;
            this.uploadController = uploadController;



       // this.editor = editor;
        this.grid = new Grid<>(Account.class);

        this.upload = new Upload( counter);



        // build layout
        HorizontalLayout actions = new HorizontalLayout(upload);
        add(actions, grid);
        upload.getDropLabel();


        grid.setHeight("300px");
        grid.setColumns("id","entryDate","valueDate","paymentDate","amount","beneficiary","accountNumber","referenceNumber","originatorsNumber","messageCardNumber","receipt");
        grid.getColumnByKey("id").setWidth("150px").setFlexGrow(0);



       upload.addSucceededListener(new ComponentEventListener<SucceededEvent>() {

            public File file;

            @Override
            public void onComponentEvent(SucceededEvent event) {
                System.out.println(event.getFileName());
              System.out.println(counter.getCSVString());

               //FileOutputStream outputStream = null;
                try {
                    FileOutputStream  outputStream  =  new FileOutputStream("C:\\Users\\SSL\\Documents\\A-TULKAUS\\9\\here.csv"  );

                    byte[] strToBytes = counter.getCSVString().getBytes();
                    try {
                        outputStream.write(counter.getCSVString().getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                }catch (final java.io.FileNotFoundException e) {
                     new Notification("Could not open file <br/>", e.getMessage(), Notification.Type.ERROR_MESSAGE).show(Page.getCurrent());


                }

            }
        });

        listAccounts(null);

        }






    // tag::listCustomers[]
    void listAccounts(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(repository.findAll());

        }
        else {
            grid.setItems(repository.findByAccountNumberStartsWithIgnoreCase(filterText));
        }
    }



    //

}