Google's Android Documentation Says that :

An asynchronous task is defined by 3 generic types, called Params, Progress and Result, and 4 steps, called onPreExecute, doInBackground, onProgressUpdate and onPostExecute.

AsyncTask's generic types :

The three types used by an asynchronous task are the following:

Params, the type of the parameters sent to the task upon execution.
Progress, the type of the progress units published during the background computation.
Result, the type of the result of the background computation.
Not all types are always used by an asynchronous task. To mark a type as unused, simply use the type Void:

 private class MyTask extends AsyncTask<Void, Void, Void> { ... }
You Can further refer : http://developer.android.com/reference/android/os/AsyncTask.html

Or You Can clear whats the role of AsyncTask by refering Sankar-Ganesh's Blog

Well The structure of a typical AsyncTask class goes like :

    private class MyTask extends AsyncTask<X, Y, Z>
  
  ---
  
    protected void onPreExecute(){
    }
This method is executed before starting the new Thread. There is no input/output values, so just initialize variables or whatever you think you need to do.

    protected Z doInBackground(X...x){

    }
The most important method in the AsyncTask class. You have to place here all the stuff you want to do in the background, in a different thread from the main one. Here we have as an input value an array of objects from the type “X” (Do you see in the header? We have “...extends AsyncTask” These are the TYPES of the input parameters) and returns an object from the type “Z”.

    protected void onProgressUpdate(Y y){
     
    }
This method is called using the method publishProgress(y) and it is usually used when you want to show any progress or information in the main screen, like a progress bar showing the progress of the operation you are doing in the background.

     protected void onPostExecute(Z z){
     
    }
This method is called after the operation in the background is done. As an input parameter you will receive the output parameter of the doInBackground method.

What about the X, Y and Z types?

As you can deduce from the above structure:

 X – The type of the input variables value you want to set to the background process. This can be an array of objects.

 Y – The type of the objects you are going to enter in the onProgressUpdate method.

 Z – The type of the result from the operations you have done in the background process.
How do we call this task from an outside class? Just with the following two lines:

    MyTask myTask = new MyTask();

    myTask.execute(x);
Where x is the input parameter of the type X.

Once we have our task running, we can find out its status from “outside”. Using the “getStatus()” method.

    myTask.getStatus();
and we can receive the following status:

* RUNNING - Indicates that the task is running.

* PENDING - Indicates that the task has not been executed yet.

* FINISHED - Indicates that onPostExecute(Z) has finished.

Hints about using AsyncTask

Do not call the methods onPreExecute, doInBackground and onPostExecute manually. This is automatically done by the system.
You cannot call an AsyncTask inside another AsyncTask or Thread. The call of the method execute must be done in the UI Thread.
The method onPostExecute is executed in the UI Thread (here you can call another AsyncTask!).
The input parameters of the task can be an Object array, this way you can put whatever objects and types you want.