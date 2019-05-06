package model.regular;

import com.google.gson.annotations.SerializedName;
import model.enums.MessageType;
import model.enums.SchemaType;
import model.helpers.HelperMessage;

public class RegularSimpleSchemaModel extends RegularModel {

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private SchemaType type;

    @SerializedName("documentType")
    private String documentType;

    @SerializedName("status")
    private String status;

    @SerializedName("locked")
    private boolean locked;

    @SerializedName("documentNumber")
    private String documentNumber;

    @SerializedName("messages")
    private HelperMessage[] messages;

    @SerializedName("actions")
    private String[] actions;

    @SerializedName("entities")
    private String[] entities;

    private  MessageType messageResult = MessageType.SUCCESS;

    public RegularSimpleSchemaModel withCode(int code) {
        this.code = code;
        return this;
    }

    public RegularSimpleSchemaModel withCodeText(String description) {
        this.codeText = description;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getCodeText() {
        return codeText;
    }

    public String getMessage() {
        return message;
    }

    public String getTestCase() {
        return testCase;
    }

    public String getId() {
        return id;
    }

    public SchemaType getType() {
        return type;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getStatus() {
        return status;
    }

    public boolean isLocked() {
        return locked;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public HelperMessage[] getMessages() {
        return messages;
    }

    public String[] getActions() {
        return actions;
    }

    public String[] getEntities() {
        return entities;
    }

    public MessageType getMessageResult() {
        return messageResult;
    }

    @Override
    public void processResponce(){

        if (messages!=null){
            for (HelperMessage item:messages) {
                if (item.getType()!=MessageType.SUCCESS){
                    messageResult = item.getType();
                    break;
                }
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegularSimpleSchemaModel regularSimpleSchemaModel = (RegularSimpleSchemaModel) o;

        if (code != regularSimpleSchemaModel.code) return false;
        if (!id.equals(regularSimpleSchemaModel.id)) return false;
        if ((documentType==null||documentType.equals(""))&(regularSimpleSchemaModel.documentType==null||regularSimpleSchemaModel.documentType.equals(""))) return false;
        if ((type==null)&(regularSimpleSchemaModel.type==null)) return false;
        return messageResult==regularSimpleSchemaModel.messageResult;
    }

    @Override
    public String toString() {
        return "SimpleSchema{" +
                "testCase=" + getTestCase() + '\'' +
                "code=" + code + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", documentType='" + documentType + '\'' +
                ", message='" + messageResult + '\'' +
                '}';
    }
}
