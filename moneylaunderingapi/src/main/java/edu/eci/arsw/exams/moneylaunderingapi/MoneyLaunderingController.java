package edu.eci.arsw.exams.moneylaunderingapi;

import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;
import edu.eci.arsw.exams.moneylaunderingapi.service.MoneyLaunderingException;
import edu.eci.arsw.exams.moneylaunderingapi.service.MoneyLaunderingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoneyLaunderingController{

    @Autowired
    MoneyLaunderingService moneyLaunderingService;

    @RequestMapping( value = "/fraud-bank-accounts", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGETRecursoAccounts(){
        List<SuspectAccount> data = null;
        data = moneyLaunderingService.getSuspectAccounts();
		return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPOSTRecursoAccounts(@RequestBody SuspectAccount sa){
        try{
            moneyLaunderingService.addSuspectAccount(sa);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(MoneyLaunderingException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping( value = "/fraud-bank-accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGETRecursoAccountsID(@PathVariable("accountId") String accountId){
        SuspectAccount datos = null;
        try{
            datos = moneyLaunderingService.getAccountStatus(accountId);
            return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
        }catch (MoneyLaunderingException e){
            return new ResponseEntity<>("ERROR 404", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/fraud-bank-accounts/{accountId}")	
    public ResponseEntity<?> manejadorPOSTRecursoAccountsID(@RequestBody SuspectAccount serviceAcc,@PathVariable("accountId") String accountId){
        try {
            moneyLaunderingService.updateAccountStatus(serviceAcc, accountId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
        }
    }

    /* curl -i -X POST -HContent-Type:application/json -HAccept:application/json http://localhost:8080/fraud-bank-accounts/ -d "{"""accountId""":"""3""","""amountOfSmallTransactions""":54}" */
    
}
