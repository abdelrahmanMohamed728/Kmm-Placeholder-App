//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Alex on 3/25/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import Combine

class HomeViewModel: ObservableObject {
    private let repo: PostsRepo
    private var cancellables = Set<AnyCancellable>()
    
    @Published var postState: [PostResponse] = []
    @Published var loadingState: Bool = false
    
    init(repo: PostsRepo) {
        self.repo = repo
        loadData()
    }
    
    private func loadData() {
        loadingState = true
        repo.getPosts()
            .receive(on: DispatchQueue.main)
            .sink { [weak self] completion in
                switch completion {
                case .failure(let error):
                    print(error.localizedDescription)
                case .finished:
                    self?.loadingState = false
                }
            } receiveValue: { [weak self] posts in
                self?.postState = posts
            }
            .store(in: &cancellables)
    }
}

