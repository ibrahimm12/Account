//package hello;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/accounts")
//public class AccountController{
//
//    private AccountService accountService;
//
//    public AccountController(AccountService accountService) {this.accountService=accountService;}
//
//    @GetMapping ("/list")
//    public Iterable<Account> list() { return accountService.list();}
//}
//
//
///*
//package hello;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//@RestController
////
//    public class AccountController {
//
//    @Autowired
//        private final AccountRepository repository;
//
//        public AccountController(AccountRepository repository) {
//            this.repository = repository;
//        }
//
//        @PostMapping(value = "/upload", consumes = "text/csv")
//        public void uploadSimple(@RequestBody InputStream body) {
//            try {
//                repository.saveAll(CsvUtils.read(Account.class, body));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @PostMapping(value = "/upload", consumes = "multipart/form-data")
//        public void uploadMultipart(@RequestParam("file") MultipartFile file) {
//            try {
//                repository.saveAll(CsvUtils.read(Account.class, file.getInputStream()));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//*/
