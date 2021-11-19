package testPackage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import testPackage.Pages.Homepage;
import testPackage.test.Helpers.DataHelper;
import testPackage.test.common.BaseTest;

public class TestClass extends BaseTest {

  Homepage homepage = new Homepage(webDriver);

  @Test(description = "Check the image is displayed on the homepage")
  public void checkImageIsDisplayed() {
    Assert.assertTrue(homepage.getPetImage().isDisplayed());
  }

  @Test(description ="Find all the Veterinarians which are added in the application and print that list")
  public void checkVeterinariansList() {
    homepage.clickOnVeterinariansTab();
    Assert.assertTrue(homepage.getVeterinariansList().isDisplayed());
    for (int i = 1;
        i <= Integer.parseInt(String.valueOf(homepage.getVeterinariansList().getSize()));
        i++) {
      String number = String.valueOf(i);
      System.out.println(
          homepage
              .getVeterinariansList()
              .findElement(By.cssSelector("tr:nth-child(" + number + ")"))
              .getText());
    }
  }

  @Test(description ="Find all the existing owners which are added in the application and print that list")
  public void checkExistingOwners() {
    homepage.clickOnFindOwnersTab();
    homepage.clickOnFindOwnerButton();
    Assert.assertTrue(homepage.getOwnersList().isDisplayed());
    for (int i = 1;
        i <= Integer.parseInt(String.valueOf(homepage.getOwnersList().getSize()));
        i++) {
      String number = String.valueOf(i);
      System.out.println(
          homepage
              .getOwnersList()
              .findElement(By.cssSelector("tr td:nth-child(" + number + ") a"))
              .getText());
    }
  }

  @Test(description ="Add new owner, add pet for that owner, And Check all the information added for the newly created owner")
  public void addNewOwnerAndPet() {
    String firstName = DataHelper.generateRandomString(10);
    String lastName = DataHelper.generateRandomString(10);
    String address = DataHelper.generateRandomString(10);
    String city = DataHelper.generateRandomString(10);
    String telephone = String.valueOf(DataHelper.generateRandomNumber(10));
    String petName = DataHelper.generateRandomString(10);
    String birthdate = "2020-10-10";
    homepage.addNewOwnerAndPet(firstName, lastName, address, city, telephone, petName, birthdate);
    Assert.assertTrue(homepage.getPetsSection().isDisplayed());
  }
}
