# SpaceCrafts
View : The user interface(UI) layer responsible for displaying the SpaceCraft list. It interacts with the ViewModel to fetch the SpaceCraft List.
ViewModel: Acts as an intermediary between the View and the UserCase. It exposes the SpaceCraft list as StateFlow for the View to observe. It receives requests from the View and communicates with the usecase to fetch the data.

UseCase : It communicate with the repository to fetch the data according to the usecase.

Repository: It interacts with  the data source (API) and provides a clean API for data access. In this case, it interacts with the Retrofit client to make API calls and fetch space craft list.

Retrofit: A type-safe HTTP client for making network requests. It handles the network operations, such as making HTTP requests, receiving responses, and parsing JSON. It communicates with the API to fetch Dog facts data.

API: The backend API that provides the Space Craft data. It receives requests from Retrofit and returns the SpaceCraft list as a response.

The flow of data starts from the View, which triggers a request for SpaceCraft data in the ViewModel. The ViewModel communicates with the usecase, and use case interact with the repository, which uses Retrofit to make an API call to fetch the data from the API. The API returns the spacecraft list as a response, which is then passed back to the usecase. The UseCase provides the data to the ViewModel, which updates its state and exposes the data to the View. Finally, the View displays the data to the user.

