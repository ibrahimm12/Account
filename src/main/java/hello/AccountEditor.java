//package hello;
//
//import com.vaadin.flow.component.Key;
//import com.vaadin.flow.component.KeyNotifier;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.icon.VaadinIcon;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.data.binder.Binder;
//import com.vaadin.flow.spring.annotation.SpringComponent;
//import com.vaadin.flow.spring.annotation.UIScope;
//import com.vaadin.ui.Label;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.File;
//
//
///**
// * A simple example to introduce building forms. As your real application is probably much
// * more complicated than this example, you could re-use this form in multiple places. This
// * example component is only used in MainView.
// * <p>
// * In a real world application you'll most likely using a common super class for all your
// * forms - less code, better UX.
// */
//@SpringComponent
//@UIScope
//public class AccountEditor extends VerticalLayout implements KeyNotifier {
//
//    private final AccountService service;
//
//    private File tempFile;
//    /**
//     * The currently edited customer
//     */
//    private Account account;
//    private Label result = new Label();
//
//
//    /* Fields to edit properties in Customer entity */
//    TextField filterText = new TextField();
//      TextField referenceNumber = new TextField("Reference Number");
//      TextField originatorNumber = new TextField("Originator Number ");
//      TextField entryDate = new TextField(" Entry date ");
//      TextField valueDate = new TextField(" Value Date ");
//      TextField paymentDate = new TextField("Payment Date ");
//      TextField amount = new TextField(" Amount");
//      TextField accountNumber = new TextField(" Account Number");
//      TextField messageCardNumber = new TextField(" Message Card Number");
//      TextField receipt = new TextField("Receipt");
//
//
//    /* Action buttons */
//    // TODO why more code?
//    Button save = new Button("Save", VaadinIcon.CHECK.create());
//    Button cancel = new Button("Cancel");
//    Button send = new Button("Cancel");
//
//    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
//    HorizontalLayout actions = new HorizontalLayout(save, cancel, delete,send);
//
//
//    Binder<Account> binder = new Binder<>(Account.class);
//    private ChangeHandler changeHandler;
//
//
//    @Autowired
//    public AccountEditor(AccountService  service ) {
//        this.service = service;
//
//
//        add(referenceNumber, originatorNumber,entryDate,valueDate, paymentDate, amount, accountNumber, messageCardNumber, receipt, actions);
//
//        // bind using naming convention
//        binder.bindInstanceFields(this);
//
//        // Configure and style components
//        setSpacing(true);
//
//        save.getElement().getThemeList().add("primary");
//        delete.getElement().getThemeList().add("error");
//
//        addKeyPressListener(Key.ENTER, e -> save());
//
//        // wire action buttons to save, delete and reset
//        save.addClickListener(e -> save());
//        delete.addClickListener(e -> delete());
//        cancel.addClickListener(e -> editAccount(account));
//        setVisible(false);
//    }
//
//
//    public void delete() {
//        service.delete(account);
//        changeHandler.onChange();
//    }
//
//    public void save() {
//        service.save(account);
//        changeHandler.onChange();
//    }
//
//    public interface ChangeHandler {
//        void onChange();
//    }
//
//
//
//
//
//
//    final void editAccount(Account c) {
//        if (c == null) {
//            setVisible(false);
//            return;
//        }
//        final boolean persisted = c.getId() != null;
//        if (persisted) {
//            // Find fresh entity for editing
//            account = service.findById(c.getId());
//        }
//        else {
//            account = c;
//        }
//        cancel.setVisible(persisted);
//
//        // Bind customer properties to similarly named fields
//        // Could also use annotation or "manual binding" or programmatically
//        // moving values from fields to entities before saving
//        binder.setBean(account);
//
//        setVisible(true);
//
//        // Focus first name initially
//        referenceNumber.focus();
//    }
//
//    void setChangeHandler(ChangeHandler h) {
//        // ChangeHandler is notified when either save or delete
//        // is clicked
//        changeHandler = h;
//    }
//
//}