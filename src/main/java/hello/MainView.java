package hello;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.router.Route;
import org.springframework.util.StringUtils;

@Route

public class MainView extends VerticalLayout {

    private final AccountService service;
   // private final UploadController uploadController;



    //private final AccountEditor editor;

     Grid<Account> grid ;


   private UploadController.LineBreakCounter counter = new UploadController.LineBreakCounter();


    private Upload upload = null;



    public MainView( AccountService service    ) {
            this.service = service;
         //   this.uploadController = uploadController;



       // this.editor = editor;
        this.grid = new Grid<>(Account.class);

        this.upload = new Upload( counter);



        // build layout
        VerticalLayout actions = new VerticalLayout(grid,upload);

        add(actions, grid);


      grid.setHeight("300px");
       grid.setColumns("id","entryDate","valueDate","paymentDate","amount","beneficiary","accountNumber","referenceNumber","originatorsReference","messageCardNumber","receipt");
      grid.getColumnByKey("id").setWidth("150px").setFlexGrow(0);
      // grid.setSizeFull();
      // grid.addColumn(s->s);



       upload.addSucceededListener(new ComponentEventListener<SucceededEvent>() {



            @Override
            public void onComponentEvent(SucceededEvent event) {
              //  System.out.println(event.getFileName());

                String [] lines=  counter.getCSVString().split(",");

                for (String line : lines) {


                    //System.out.println(line);
                    Account c = new Account();
                    c.setEntryDate(lines[0]);
                    c.setValueDate(lines[1]);
                    c.setPaymentDate(lines[2]);
                    c.setAmount(lines[3]);
                    c.setBeneficiary(lines[4]);
                    c.setAccountNumber(lines[5]);
                    c.setReferenceNumber(lines[6]);
                    c.setOriginatorsReference(lines[7]);
                    c.setMessageCardNumber(lines[8]);
                    c.setReceipt(lines[9]);
                    service.save(c);


                }




            }
        });

        listAccounts(null);

        }






    // tag::listCustomers[]
    void listAccounts(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(service.findById());

        }
        else {
            grid.setItems(service.findByReferenceNumberStartsWithIgnoreCase(filterText));
        }
    }



    //

}