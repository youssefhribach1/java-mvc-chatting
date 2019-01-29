package controller;

import dto.CommandDTO;
import dto.MessageDTO;
import service.ChatService;

/**
 * ChatController :: Using Socket :: accept, connect, disconnect, send(1:N, 1:1)
 *
 * param pattern = Method handler
 *       rno = Target room(or user) number
 *       *FIXME userName = id (Name and id are the same!)
 *       message = Chatting text
 */
public class ChatController implements IController{
    private static ChatController chatController = new ChatController();
    private ChatService chatService = ChatService.getInstance();
    private ChatController() {}
    public static ChatController getInstance() {
        return chatController;
    }

    public void in(String pattern) {

    }
    public void in(String pattern, CommandDTO commandDTO) {
        // FIXME Constructor
        MessageDTO messageDTO = new MessageDTO(commandDTO.getRno(), commandDTO.getUserName(), commandDTO.getText());

        if(pattern.equals("sendBroadCast")) {
            this.sendBroadCast(messageDTO);
        } else if(pattern.equals("sendRno")) {
            // TODO 1:1
        } else if(pattern.equals("connect")) {
            System.out.println("connect");
            this.socketConnect(commandDTO);
        } else if(pattern.equals("disconnect")) {
            this.disconnect(commandDTO);
        }
    }

    private void socketConnect(CommandDTO commandDTO) {
        chatService.init(commandDTO);
    }
    private void sendBroadCast(MessageDTO messageDTO) {
        chatService.sendBroadCast(messageDTO);
    }
    private void disconnect(CommandDTO commandDTO){
        chatService.disconnect(commandDTO);
    }
}
