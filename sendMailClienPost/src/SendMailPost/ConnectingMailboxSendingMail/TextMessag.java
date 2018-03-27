package SendMailPost.ConnectingMailboxSendingMail;

public class TextMessag {

    public void setMessageHeader(String messageHeader) {
        this.messageHeader = messageHeader;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getMessageHeader() {
        return messageHeader;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public String getFirmName() {
        return firmName;
    }

    private String firmName = "";

//    private String messageHeader = "Уведомление о перерыве связи 10.03.2018 г.";
    private String messageHeader = "Счёт для";

    private String textMessage = new String("   Компания Теленэт благодарит Вас за сотрудничество \n" +
            "Внимание!!! Это автоматическая рассылка, не требующая ответа.\n" +
            "Документы находятся в прикреплённых файлах\n" +
            "По все вопросам обращаться по тел. +7-495-777-23-33\n" +
            "или по электронному адресу: info@telefonet.ru");

//    private String textMessage = new String("Здравствуйте.\n" +
//        "\n" +
//        "Уведомляем Вас, что 05.03.2018 г. в период с 06:00 до 06:30 будет перерывы в предоставлении услуг связи продолжительностью не более 30 секунд.\n" +
//        "Перерыв вызван необходимость провести работы на сети ООО \"Теленэт\"\n" +
//        "\n" +
//        "Вынуждены сообщить, что перенести или отменить данные работы, к сожалению, невозможно.\n" +
//        "\n" +
//        "Приносим извинения за доставленные неудобства, и надеемся на Ваше понимание.");
}
