package concurrency;

import java.util.concurrent.CompletableFuture;

class Driver{
    public static void main(String[] args) {
      
        CompletableFuture<User> userAsync = CompletableFuture.supplyAsync(()->userService.getUser(userId));
        CompletableFuture<UserPreferences> userPreferencesAsync = CompletableFuture.supplyAsync(()->userPreferencesService.getPreference(userId)));
        CompletableFuture<Void> bothFutures = CompletableFuture.allOf(userAsync, userPreferencesAsync);
        bothFutures.join();
    }
}