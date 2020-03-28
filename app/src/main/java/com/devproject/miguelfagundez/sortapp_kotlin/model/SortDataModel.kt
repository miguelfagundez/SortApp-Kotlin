package com.devproject.miguelfagundez.sortapp_kotlin.model


/********************************************
 * SortDataModel - Base Model class
 * This class handle example data that
 * is showed in the RecyclerView
 * @author: Miguel Fagundez
 * @date: March 27th, 2020
 * @version: 1.0
 * *******************************************/
class SortDataModel {

    //*************************************************
    // Generate initial data
    //*************************************************
    fun dataModel(): MutableList<SortModel>? {
        val friendList = mutableListOf<SortModel>()
        //****************************
        // Creating example data
        //****************************
        var friend = SortModel("Andrea", 43, 9)
        friendList.add(friend)
        friend = SortModel("Carlos", 31, 7)
        friendList.add(friend)
        friend = SortModel("Armando", 29, 3)
        friendList.add(friend)
        friend = SortModel("Cesar", 91, 6)
        friendList.add(friend)
        friend = SortModel("Miguel", 45, 7)
        friendList.add(friend)
        friend = SortModel("Karina", 76, 9)
        friendList.add(friend)
        friend = SortModel("Juanes", 21, 4)
        friendList.add(friend)
        friend = SortModel("Zulay", 49, 12)
        friendList.add(friend)
        friend = SortModel("Samantha", 61, 8)
        friendList.add(friend)
        friend = SortModel("Rebeca", 66, 17)
        friendList.add(friend)
        friend = SortModel("Mathew", 33, 9)
        friendList.add(friend)
        friend = SortModel("John", 61, 11)
        friendList.add(friend)
        friend = SortModel("Nancy", 49, 13)
        friendList.add(friend)
        friend = SortModel("Linda", 55, 17)
        friendList.add(friend)
        friend = SortModel("Veronica", 22, 10)
        friendList.add(friend)
        friend = SortModel("Daniel", 45, 5)
        friendList.add(friend)
        friend = SortModel("Roman", 44, 12)
        friendList.add(friend)
        friend = SortModel("Carmen", 66, 8)
        friendList.add(friend)
        friend = SortModel("Keny", 29, 2)
        friendList.add(friend)
        friend = SortModel("Yesika", 33, 16)
        friendList.add(friend)
        friend = SortModel("William", 45, 17)
        friendList.add(friend)

        // returning data
        return friendList
    }
}