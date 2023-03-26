//
//  HomeScreen.swift
//  iosApp
//
//  Created by Alex on 3/25/23.
//  Copyright © 2023 orgName. All rights reserved.
//

struct HomeScreen: View {
    @StateObject var viewModel = HomeViewModel()
    
    var body: some View {
        ZStack {
            Color.white
                .ignoresSafeArea()
            VStack {
                Text("KMM Dummy Project")
                    .font(.headline)
                    .padding(.bottom, 8)
                ChipSection(title: "This is a placeholder list", chips: viewModel.postState)
                    .padding(.vertical, 16)
            }
            .padding(EdgeInsets(top: 16, leading: 24, bottom: 16, trailing: 24))
            .background(Color.white)
        }
    }
}

struct ChipSection: View {
    let title: String
    let chips: [PostResponse]
    
    var body: some View {
        VStack {
            Text(title)
                .font(.headline)
                .padding(.leading, 16)
                .padding(.bottom, 8)
            ScrollView(.horizontal, showsIndicators: false) {
                HStack {
                    ForEach(chips) { chip in
                        CardView(chip: chip)
                            .padding(.leading, 8)
                            .padding(.bottom, 8)
                    }
                }
                .padding(.trailing, 16)
            }
        }
    }
}

struct CardView: View {
    let chip: PostResponse
    
    var body: some View {
        Text(chip.title)
            .font(.subheadline)
            .foregroundColor(.white)
            .padding(.horizontal, 16)
            .padding(.vertical, 8)
            .background(Color.secondary)
            .cornerRadius(16)
    }
}

