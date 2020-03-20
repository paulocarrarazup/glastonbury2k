package br.com.zup.order.orchestrator.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class PaymentTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String paymentResult = (String)delegateExecution.getVariable("PAYMENT_RESULT");

        System.out.println("Payment: " + paymentResult);
    }
}
