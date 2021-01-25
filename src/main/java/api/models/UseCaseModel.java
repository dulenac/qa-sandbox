package api.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"usecase_id", "user_id", "title", "expected_result", "description", "automated"})
public class UseCaseModel {

    int usecase_id;
    int user_id;
    String title;
    String expected_result;
    String description;
    boolean automated;

    public int getUsecase_id() {
        return usecase_id;
    }

    public void setUsecase_id(int usecase_id) {
        this.usecase_id = usecase_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpected_result() {
        return expected_result;
    }

    public void setExpected_result(String expected_result) {
        this.expected_result = expected_result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAutomated() {
        return automated;
    }

    public void setAutomated(boolean automated) {
        this.automated = automated;
    }
}
