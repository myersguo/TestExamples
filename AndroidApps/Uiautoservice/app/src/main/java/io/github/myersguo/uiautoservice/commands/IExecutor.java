package io.github.myersguo.uiautoservice.commands;


public interface IExecutor {
    public void execute(CommandRequest request, CommandResponse response) throws  Exception;
}
